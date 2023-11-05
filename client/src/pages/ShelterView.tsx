import { useState } from "react"
import Navbar from "../reusable/Navbar"
import Sidebar from "../reusable/Sidebar"
import Content from "../reusable/Content/Content"

type ContentView = "card" | "list"
type PaneView = "pets" | "volunteers" | "supplies" | "profile" | "none"

export default function ShelterView() {

    const [paneView, setPaneView] = useState<PaneView>("none")
    const [contentView, setContentView] = useState<ContentView>("card")
    const [searchText, setSearchText] = useState<String>("")

    return (
        <>
            <Sidebar paneView={paneView} setPaneView={setPaneView} />
            <div className="h-full w-full">
                <Navbar accountType={"shelter"} contentView={contentView} setContentView={setContentView} setSearchText={setSearchText} searchPlaceholderText={"Search"} />
                <Content />
            </div>
        </>
    )
}
