import { useContext } from "react"
import { AccountContext } from "../App"

export default function Sidebar() {

    // @ts-ignore
    const { accountType, setAccountType } = useContext(AccountContext)

    return (
        <>
            <div className="hidden sm:block sm:h-full sm:w-72 sm:border-r-2 sm:border-r-black sm:border-t-0 border-t-2 border-t-black" >{accountType} sidebar</div>
        </>
    )
}