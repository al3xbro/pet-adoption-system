import { useContext } from "react"
import { AccountContext } from "../App"
import { Link } from "react-router-dom"

export default function Sidebar() {

    // @ts-ignore
    const { accountType, setAccountType } = useContext(AccountContext)

    return (
        <>
            <div className="hidden sm:flex h-full w-72 sm:border-r-2 sm:border-r-black sm:border-t-0 border-t-2 border-t-black overflow-y-auto flex-col p-4 gap-2" >
                {accountType == "customer" ?
                    <>
                        <div className="aspect-square border-2 rounded-xl overflow-hidden m-4">
                            <img src="https://tr.rbxcdn.com/38c6edcb50633730ff4cf39ac8859840/420/420/Hat/Png" className="w-full h-2/3 object-cover" />
                            <div className="h-1/3 w-full bg-gray-200">Gabriel's Animal Home</div>
                        </div>
                        <hr className="bg-gray-900 my-2 border-0 h-[1.5px]" />
                        <div className="flex flex-col">
                            <Link className="p-4 text-center rounded-lg text-2xl sm:hover:bg-gray-200 active:bg-gray-200 transition duration-200 ease-in-out" to="/pets">Pets</Link>
                            <Link className="p-4 text-center rounded-lg text-2xl sm:hover:bg-gray-200 active:bg-gray-200 transition duration-200 ease-in-out" to="/shelters">Shelters</Link>
                        </div>
                    </>
                    : null
                }
                {accountType == "volunteer" ?
                    <>
                        <div className="aspect-square border-2 rounded-xl overflow-hidden m-4">
                            <img src="https://tr.rbxcdn.com/38c6edcb50633730ff4cf39ac8859840/420/420/Hat/Png" className="w-full h-2/3 object-cover" />
                            <div className="h-1/3 w-full bg-gray-200">Gabriel's Animal Home</div>
                        </div>
                        <hr className="bg-gray-900 my-2 border-0 h-[1.5px]" />
                        <div className="flex flex-col">
                            <Link className="p-4 text-center rounded-lg text-2xl sm:hover:bg-gray-200 active:bg-gray-200 transition duration-200 ease-in-out" to="/pets">Pets</Link>
                            <Link className="p-4 text-center rounded-lg text-2xl sm:hover:bg-gray-200 active:bg-gray-200 transition duration-200 ease-in-out" to="/customers">Customers</Link>
                            <Link className="p-4 text-center rounded-lg text-2xl sm:hover:bg-gray-200 active:bg-gray-200 transition duration-200 ease-in-out" to="/shelters">Shelters</Link>
                            <Link className="p-4 text-center rounded-lg text-2xl sm:hover:bg-gray-200 active:bg-gray-200 transition duration-200 ease-in-out" to="/logs">Logs</Link>
                        </div>
                    </>
                    : null
                }
                {accountType == "shelter" ?
                    <>
                        <div className="aspect-square border-2 rounded-xl overflow-hidden m-4">
                            <img src="https://tr.rbxcdn.com/38c6edcb50633730ff4cf39ac8859840/420/420/Hat/Png" className="w-full h-2/3 object-cover" />
                            <div className="h-1/3 w-full bg-gray-200">Gabriel's Animal Home</div>
                        </div>
                        <hr className="bg-gray-900 my-2 border-0 h-[1.5px]" />
                        <div className="flex flex-col">
                            <Link className="p-4 text-center rounded-lg text-2xl sm:hover:bg-gray-200 active:bg-gray-200 transition duration-200 ease-in-out" to="/pets">Pets</Link>
                            <Link className="p-4 text-center rounded-lg text-2xl sm:hover:bg-gray-200 active:bg-gray-200 transition duration-200 ease-in-out" to="/customers">Customers</Link>
                            <Link className="p-4 text-center rounded-lg text-2xl sm:hover:bg-gray-200 active:bg-gray-200 transition duration-200 ease-in-out" to="/volunteers">Volunteers</Link>
                            <Link className="p-4 text-center rounded-lg text-2xl sm:hover:bg-gray-200 active:bg-gray-200 transition duration-200 ease-in-out" to="/shelters">Shelters</Link>
                            <Link className="p-4 text-center rounded-lg text-2xl sm:hover:bg-gray-200 active:bg-gray-200 transition duration-200 ease-in-out" to="/logs">Logs</Link>
                        </div>
                    </>
                    : null
                }
            </div >
        </>
    )
}