import { useState } from "react"
import Navbar from "../reusable/Navbar"
import Sidebar from "../reusable/Sidebar"
import Content from "../reusable/Content/Content"
import { BrowserRouter, Route, Routes } from "react-router-dom"

type ContentView = "card" | "list"


export default function Main() {

    const [contentView, setContentView] = useState<ContentView>("card")

    return (
        <>
            <BrowserRouter>
                <Sidebar />
                <div className="h-full w-full sm:w-[calc(100%-18rem)]">
                    <Routes>
                        <Route path="/" element={
                            <>
                                <Navbar paneView="none" contentView={contentView} setContentView={setContentView} />
                            </>
                        } />
                        <Route path="/profile" element={
                            <>
                                <Navbar paneView="profile" contentView={contentView} setContentView={setContentView} />
                                <div>profile here</div>
                            </>
                        } />
                        <Route path="/volunteers" element={
                            <>
                                <Navbar paneView="volunteers" contentView={contentView} setContentView={setContentView} />
                                <Content paneView="volunteers" contentView={contentView} />
                            </>
                        } />
                        <Route path="/customers" element={
                            <>
                                <Navbar paneView="customers" contentView={contentView} setContentView={setContentView} />
                                <Content paneView="customers" contentView={contentView} />
                            </>
                        } />
                        <Route path="/pets" element={
                            <>
                                <Navbar paneView="pets" contentView={contentView} setContentView={setContentView} />
                                <Content paneView="pets" contentView={contentView} />
                            </>
                        } />
                        <Route path="/shelters" element={
                            <>
                                <Navbar paneView="shelters" contentView={contentView} setContentView={setContentView} />
                                <Content paneView="shelters" contentView={contentView} />
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
