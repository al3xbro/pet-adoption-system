import { useEffect, useState } from "react"
import Navbar from "../reusable/Navbar"
import Sidebar from "../reusable/Sidebar"
import Content from "../reusable/Content/Content"
import throttle from "lodash.throttle"

type ContentView = "card" | "list"
type PaneView = "pets" | "volunteers" | "supplies" | "profile" | "none"

// throttle function to prevent spamming the server with requests
const throttleFunction = throttle((searchText) => {
    console.log("searching for " + searchText)
}, 500)

export default function ShelterView() {

    const [paneView, setPaneView] = useState<PaneView>("none")
    const [contentView, setContentView] = useState<ContentView>("card")

    const [searchText, setSearchText] = useState<string>("")

    useEffect(() => {
        throttleFunction(searchText)
    }, [searchText])

    return (
        <>
            <Sidebar paneView={paneView} setPaneView={setPaneView} />
            <div className="h-full w-full">
                <Navbar accountType={"shelter"} contentView={contentView} setContentView={setContentView} searchText={searchText} setSearchText={setSearchText} searchPlaceholderText={"Search"} />
                <Content />
            </div>
        </>
    )
}
