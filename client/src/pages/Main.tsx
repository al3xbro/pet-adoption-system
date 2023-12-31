import { useContext, useState } from "react"
import { BrowserRouter, Route, Routes } from "react-router-dom"
import { AccountContext } from "../App"
import Content from "../reusable/Content/Content"
import Navbar from "../reusable/Navbar"
import Sidebar from "../reusable/Sidebar"
import CustomerProfile from "./CustomerProfile"
import ShelterProfile from "./ShelterProfile"
import VolunteerProfile from "./VolunteerProfile"

type ContentView = "card" | "list"

type Account = "shelter" | "volunteer" | "customer"
type AccountContextType = {
    accountType: Account,
    setAccountType: React.Dispatch<React.SetStateAction<Account>>
}

function profileSwitch(accountContext: AccountContextType | undefined) {
    switch (accountContext?.accountType) {
        case "customer":
            return <CustomerProfile />
        case "volunteer":
            return <VolunteerProfile />
        case "shelter":
            return <ShelterProfile />
    }
}


export default function Main() {

    const accountContext = useContext(AccountContext)
    const [contentView, setContentView] = useState<ContentView>("card")

    return (
        <>
            <BrowserRouter>
                <Sidebar />
                <div className="h-full w-full sm:w-[calc(100%-18rem)] select-none">
                    <Routes>
                        <Route path="/" element={
                            <>
                                <Navbar paneView="none" contentView={contentView} setContentView={setContentView} />
                            </>
                        } />
                        <Route path="/profile" element={
                            <>
                                <Navbar paneView="profile" contentView={contentView} setContentView={setContentView} />
                                {
                                    profileSwitch(accountContext)
                                }
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
                        <Route path="/logs" element={
                            <>
                                <Navbar paneView="profile" contentView={contentView} setContentView={setContentView} />
                                <Content paneView="logs" contentView={contentView} />
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
