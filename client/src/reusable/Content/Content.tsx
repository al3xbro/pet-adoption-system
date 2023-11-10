import axios from "axios"
import Card from "./Card"
import ListElement from "./ListElement"
import { useQuery } from "@tanstack/react-query"

type ContentView = "card" | "list"
type PaneView = "supplies" | "volunteers" | "pets"
type DataEntry = {
    id: number,
    name: string,
    summary: string,
    desc: string,
    img: string,
}

type Props = {
    contentView: ContentView,
    paneView: PaneView
}

// get query params and fetches data here

export default function Content({ contentView, paneView }: Props) {

    const { searchParams } = new URL(window.location.href)
    const name = searchParams.get("q")
    // FIXME: endpoint
    const query = useQuery({
        queryKey: ["pet", name],
        queryFn: async () => {
            return axios.get(`http://localhost:5000/${paneView}/name/${name}`)
        }
    })
    const data: Array<DataEntry> = query.data?.data

    return (
        <>
            {contentView == "card" ?
                <div style={{ gridTemplateColumns: "repeat(auto-fill, minmax(20rem, 1fr))", gridAutoRows: "13rem" }} className="grid gap-8 h-[calc(100%-4rem)] overflow-y-auto p-6">
                    {data.map((element) => <Card key={element.id} name={element.name} summary={element.summary} desc={element.desc} img={element.img} />)}
                </div>
                : <div className="h-[calc(100%-4rem)] overflow-y-auto px-6">
                    {data.map((element) => <ListElement key={element.id} name={element.name} summary={element.summary} desc={element.desc} img={element.img} />)}
                </div>
            }
        </>
    )
}