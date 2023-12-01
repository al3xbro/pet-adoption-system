import axios from "axios"
import Card from "./Card"
import ListElement from "./ListElement"
import { useQuery } from "@tanstack/react-query"
import { useSearchParams } from "react-router-dom"
import { useEffect } from "react"

type ContentView = "card" | "list"
type PaneView = "customers" | "volunteers" | "pets" | "shelters"

type Props = {
    contentView: ContentView,
    paneView: PaneView
}

export default function Content({ contentView, paneView }: Props) {

    let [searchParams] = useSearchParams();
    let name = searchParams.get("q");

    // FIXME: endpoint
    const query = useQuery({
        queryKey: [paneView, name],
        queryFn: async () => {
            if (!name) return axios.get(`http://localhost:8080/api/${paneView}`)
            else return axios.get(`http://localhost:8080/api/${paneView}/name/${name}`)
        }
    })
    // EVERYBODY PANIC THERE IS NO TYPE SAFETY AHHHHHHHHHH

    useEffect(() => {
        console.log(searchParams.get("q"))
        query.refetch()
    }, [searchParams])

    // FIXME: json data
    const cardFactory = (element: any) => {
        switch (paneView) {
            case "pets":
                return <Card key={element.id} name={element.name} summary={`${element.sex} - ${element.age > 12 ? `${Math.floor(element.age / 12)}yr` : `${element.age}mo`} - ${element.breed}`} desc={element.desc} img={element.img} />
            case "volunteers":
                return <Card key={element.id} name={element.name} summary={element.hours} desc={""} img={element.img} />
            case "customers":
                return <Card key={element.id} name={element.name} summary={""} desc={`${element.phone} - ${element.address}`} img={element.img} />
            case "shelters":
                return <Card key={element.id} name={element.name} summary={`${element.numAdoptions} adoptions`} desc={`${element.phone} - ${element.address}`} img={element.img} />
        }
    }

    const listElementFactory = (element: any) => {
        switch (paneView) {
            case "pets":
                return <ListElement key={element.id} name={element.name} summary={`${element.sex} - ${element.age > 12 ? `${Math.floor(element.age / 12)}yr` : `${element.age}mo`} - ${element.breed}`} desc={element.desc} img={element.img} />
            case "volunteers":
                return <ListElement key={element.id} name={element.name} summary={element.hours} desc={""} img={element.img} />
            case "customers":
                return <ListElement key={element.id} name={element.name} summary={""} desc={`${element.phone} - ${element.address}`} img={element.img} />
            case "shelters":
                return <ListElement key={element.id} name={element.name} summary={`${element.numAdoptions} adoptions`} desc={`${element.phone} - ${element.address}`} img={element.img} />
        }
    }

    return (
        <>
            {
                query.isSuccess ?
                    contentView == "card" ?
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