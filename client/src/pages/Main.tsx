import { useEffect, useState } from "react"
import Navbar from "../reusable/Navbar"
import Sidebar from "../reusable/Sidebar"
import Content from "../reusable/Content/Content"
import throttle from "lodash.throttle"
import { BrowserRouter, Route, Routes } from "react-router-dom"

type ContentView = "card" | "list"

// throttle function to prevent spamming the server with requests
const throttleRequest = throttle((searchText) => {
    // TODO: add query params to link
}, 500)

export default function Main() {

    const [contentView, setContentView] = useState<ContentView>("card")
    const [searchText, setSearchText] = useState<string>("")

    // call throttle function on searchText change
    useEffect(() => {
        throttleRequest(searchText)
    }, [searchText])

    return (
        <>
            <BrowserRouter>
                <Sidebar />
                <div className="h-full w-full">
                    <Routes>
                        <Route path="/" element={
                            <>
                                <Navbar paneView="none" contentView={contentView} setContentView={setContentView} searchText={searchText} setSearchText={setSearchText} />
                            </>
                        } />
                        <Route path="/profile" element={
                            <>
                                <Navbar paneView="profile" contentView={contentView} setContentView={setContentView} searchText={searchText} setSearchText={setSearchText} />
                                <div>profile here</div>
                            </>
                        } />
                        <Route path="/supplies" element={
                            <>
                                <Navbar paneView="supplies" contentView={contentView} setContentView={setContentView} searchText={searchText} setSearchText={setSearchText} />
                                <Content />
                            </>
                        } />
                        <Route path="/volunteers" element={
                            <>
                                <Navbar paneView="volunteers" contentView={contentView} setContentView={setContentView} searchText={searchText} setSearchText={setSearchText} />
                                <Content />
                            </>
                        } />
                        <Route path="/pets" element={
                            <>
                                <Navbar paneView="pets" contentView={contentView} setContentView={setContentView} searchText={searchText} setSearchText={setSearchText} />
                                <Content />
                            </>
                        } />
                        <Route path="/*" element={
                            <div>
                                not found
                            </div>

                        } />
                    </Routes>
                </div>
            </BrowserRouter>
        </>
    )
}
