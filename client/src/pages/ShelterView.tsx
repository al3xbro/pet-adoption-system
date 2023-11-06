import { useEffect, useState } from "react"
import Navbar from "../reusable/Navbar"
import Sidebar from "../reusable/Sidebar"
import Content from "../reusable/Content/Content"
import throttle from "lodash.throttle"
import { BrowserRouter, Route, Routes } from "react-router-dom"

type AccountType = 'customer' | 'employee' | 'shelter'
type ContentView = "card" | "list"
type Props = {
    setAccountType: React.Dispatch<React.SetStateAction<AccountType>>
}

// throttle function to prevent spamming the server with requests
const throttleRequest = throttle((searchText) => {
    // TODO: axios query here with suerystring
}, 500)

export default function ShelterView({ setAccountType }: Props) {

    const [contentView, setContentView] = useState<ContentView>("card")
    const [searchText, setSearchText] = useState<string>("")

    // call throttle function on searchText change
    useEffect(() => {
        throttleRequest(searchText)
    }, [searchText])

    return (
        <>
            <BrowserRouter>
                <Sidebar accountType={"shelter"} />
                <div className="h-full w-full">
                    <Navbar accountType={"shelter"} setAccountType={setAccountType} contentView={contentView} setContentView={setContentView} searchText={searchText} setSearchText={setSearchText} searchPlaceholderText={"Search"} />
                    <Routes>
                        <Route path="/" element={<Content />} />
                        <Route path="/profile" element={<div>profile</div> /* profile here, profile component responsible for fetching */} />
                        <Route path="/volunteers" element={<Content />} />
                        <Route path="/supplies" element={<Content />} />
                        <Route path="/profile" element={<Content />} />
                    </Routes>
                </div>
            </BrowserRouter>
        </>
    )
}
