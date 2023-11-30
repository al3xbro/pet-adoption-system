import axios from "axios"
import Card from "./Card"
import ListElement from "./ListElement"
import { useQuery } from "@tanstack/react-query"

type ContentView = "card" | "list"
type PaneView = "customers" | "volunteers" | "pets" | "shelters"

type Props = {
    contentView: ContentView,
    paneView: PaneView
}

const defaultCards = [
    {
        id: 1,
        name: "Fluffyfasdfasdfasdfasdfadfasd",
        sex: "M",
        age: 24,
        breed: "Poodle",
        desc: "Fluffy is a happy dog who loves to play fetch",
        img: "https://ih1.redbubble.net/image.2653429219.4814/st,small,507x507-pad,600x600,f8f8f8.webp"
    },
    {
        id: 2,
        name: "Mittensfasdfasdafasdfasdfas",
        sex: "F",
        age: 36,
        breed: "Tabby",
        desc: "Mittens is a happy cat who loves to play with yarn",
        img: "https://ih1.redbubble.net/image.2653429219.4814/st,small,507x507-pad,600x600,f8f8f8.webp"

    },
    {
        id: 3,
        name: "Bubbles",
        sex: "M",
        age: 12,
        breed: "Goldfish",
        desc: "Bubbles is a happy fish who loves to swim",
        img: "https://ih1.redbubble.net/image.2653429219.4814/st,small,507x507-pad,600x600,f8f8f8.webp"

    },
    {
        id: 4,
        name: "Croc",
        sex: "F",
        age: 36,
        breed: "Crocodile",
        desc: "Croc is a happy crocodile who loves to eat",
        img: "https://ih1.redbubble.net/image.2653429219.4814/st,small,507x507-pad,600x600,f8f8f8.webp"

    }
]

export default function Content({ contentView, paneView }: Props) {

    const { searchParams } = new URL(window.location.href)
    const name = searchParams.get("q")
    // FIXME: endpoint
    const query = useQuery({
        queryKey: ["pet", name],
        queryFn: async () => {
            return axios.get(`http://localhost:5000/api/${paneView}/name/${name}`)
        }
    })
    const data: Array<any> = query.data?.data ?? defaultCards
    // EVERYBODY PANIC THERE IS NO TYPE SAFETY AHHHHHHHHHH

    const cardFactory = (element: any) => {
        switch (paneView) {
            case "pets":
                return <Card key={element.id} name={element.name} summary={`${element.sex} - ${element.age > 12 ? `${Math.floor(element.age / 12)}yr` : `${element.age}mo`} - ${element.breed}`} desc={element.desc} img={element.img} />
            case "volunteers":
            case "customers":
            case "shelters":
        }
    }

    const listElementFactory = (element: any) => {
        switch (paneView) {
            case "pets":
                return <ListElement key={element.id} name={element.name} summary={`${element.sex} - ${element.age > 12 ? `${Math.floor(element.age / 12)}yr` : `${element.age}mo`} - ${element.breed}`} desc={element.desc} img={element.img} />
            case "volunteers":
            case "customers":
            case "shelters":
        }
    }

    return (
        <>
            {contentView == "card" ?
                <div style={{ gridTemplateColumns: "repeat(auto-fill, minmax(20rem, 1fr))", gridAutoRows: "13rem" }} className="grid gap-8 h-[calc(100%-4rem)] overflow-y-auto p-6">
                    {data.map((element) => cardFactory(element))}
                </div>
                : <div className="h-[calc(100%-4rem)] overflow-y-auto px-6 py-2">
                    {data.map((element) => listElementFactory(element))}
                </div>
            }
        </>
    )
}