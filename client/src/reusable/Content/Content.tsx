import { useQuery } from "@tanstack/react-query"
import axios from "axios"
import { useContext, useEffect } from "react"
import { useSearchParams } from "react-router-dom"
import { AccountContext } from "../../App"
import Card from "./Card"
import ListElement from "./ListElement"

type ContentView = "card" | "list"
type PaneView = "customers" | "volunteers" | "pets" | "shelters" | "logs"

type Props = {
    contentView: ContentView,
    paneView: PaneView
}

export default function Content({ contentView, paneView }: Props) {

    const [searchParams] = useSearchParams()
    const accountContext = useContext(AccountContext)
    const accountType = accountContext?.accountType

    let query: any
    if (accountType == "customer" && paneView == "pets") {
        query = useQuery({
            queryKey: [paneView],
            queryFn: async () => {
                if (!searchParams.get("q")) return axios.get(`http://localhost:8080/api/pets/available/`)
                else return axios.get(`http://localhost:8080/api/pets/available/${searchParams.get("q")}`)
            }
        })
    } else {
        query = useQuery({
            queryKey: [paneView],
            queryFn: async () => {
                if (!searchParams.get("q")) return axios.get(`http://localhost:8080/api/${paneView}`)
                else return axios.get(`http://localhost:8080/api/${paneView}/name/${searchParams.get("q")}`)
            }
        })
    }

    useEffect(() => {
        query.refetch()
    }, [searchParams, accountType])

    // EVERYBODY PANIC THERE IS NO TYPE SAFETY AHHHHHHHHHH

    const cardFactory = (element: any) => {
        switch (paneView) {
            case "pets":
                return <Card key={element.id} id={element.id} name={element.name} shelterId={element.shelterId} summary={`${element.sex} - ${element.age > 12 ? `${Math.floor(element.age / 12)}yr` : `${element.age}mo`} - ${element.breed}`} desc={element.desc} img={element.img} isPet={true} />
            case "volunteers":
                return <Card key={element.id} id={element.id} shelterId={0} name={`${element.firstName} ${element.lastName}`} summary={`${element.hoursWorked} hrs`} desc={""} img={element.img} isPet={false} />
            case "customers":
                return <Card key={element.id} id={element.id} shelterId={0} name={`${element.firstName} ${element.lastName}`} summary={""} desc={`${element.phone} - ${element.address}`} img={element.img} isPet={false} />
            case "shelters":
                return <Card key={element.id} id={element.id} shelterId={0} name={element.name} summary={`${element.numAdoptions} adoptions`} desc={`${element.phone} - ${element.address}`} img={element.img} isPet={false} />
            case "logs":
                return <ListElement key={element.id} name={element.petName} summary={element.customerName} desc={`by ${element.volunteerName} at ${element.shelterName}`} img="" />
        }
    }

    const listElementFactory = (element: any) => {
        switch (paneView) {
            case "pets":
                return <ListElement key={element.id} name={element.name} summary={`${element.sex} - ${element.age > 12 ? `${Math.floor(element.age / 12)}yr` : `${element.age}mo`} - ${element.breed}`} desc={element.desc} img={element.img} />
            case "volunteers":
                return <ListElement key={element.id} name={`${element.firstName} ${element.lastName}`} summary={`${element.hoursWorked} hrs`} desc={""} img={element.img} />
            case "customers":
                return <ListElement key={element.id} name={`${element.firstName} ${element.lastName}`} summary={""} desc={`${element.phone} - ${element.address}`} img={element.img} />
            case "shelters":
                return <ListElement key={element.id} name={element.name} summary={`${element.numAdoptions} adoptions`} desc={`${element.phone} - ${element.address}`} img={element.img} />
            case "logs":
                return <ListElement key={element.id} name={element.petName} summary={element.customerName} desc={`by ${element.volunteerName} at ${element.shelterName}`} img="" />
        }
    }

    return (
        <>
            {
                query.isSuccess ?
                    contentView == "card" && paneView != "logs" ?
                        <div style={{ gridTemplateColumns: "repeat(auto-fill, minmax(20rem, 1fr))", gridAutoRows: "13rem" }} className="grid gap-8 h-[calc(100%-4rem)] overflow-y-auto p-6">
                            {query.data?.data.map((element: any) => cardFactory(element))}
                        </div>
                        : <div className="h-[calc(100%-4rem)] overflow-y-auto px-6 py-2">
                            {query.data?.data.map((element: any) => listElementFactory(element))}
                        </div>
                    : null
            }
        </>
    )
}