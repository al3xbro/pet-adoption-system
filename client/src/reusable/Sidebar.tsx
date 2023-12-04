import { useContext } from "react"
import { AccountContext } from "../App"
import { Link } from "react-router-dom"

export default function Sidebar() {

    // @ts-ignore
    const { accountType, setAccountType } = useContext(AccountContext)

    // TODO: add login account query, hard code for now
    return (
        <>
            <div className="select-none hidden sm:flex h-full w-72 sm:border-r-2 sm:border-r-black sm:border-t-0 border-t-2 border-t-black overflow-y-auto flex-col p-4 gap-2 " >
                {accountType == "customer" ?
                    <>
                        <Link className="aspect-square border-2 rounded-xl overflow-hidden m-4" to="/profile">
                            <img src="https://github.com/al3xbro/pet-adoption-system/blob/main/assets/Alex%20Bui.jpg?raw=true" className="w-full h-2/3 object-cover" />
                            <div className="h-1/3 w-full bg-gray-200 p-2 text-xl flex items-center justify-center">
                                <div className="text-center w-fit h-fit">
                                    Alex Bui
                                </div>
                            </div>
                        </Link>
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
                        <Link className="aspect-square border-2 rounded-xl overflow-hidden m-4" to="/profile">
                            <img src="https://github.com/al3xbro/pet-adoption-system/blob/main/assets/Madison.jpeg?raw=true" className="w-full h-2/3 object-cover" />
                            <div className="h-1/3 w-full bg-gray-200 p-2 text-xl flex items-center justify-center">
                                <div className="text-center w-fit h-fit">
                                    Madison Kolley
                                </div>
                            </div>
                        </Link>
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
                        <Link className="aspect-square border-2 rounded-xl overflow-hidden m-4" to="/profile">
                            <img src="https://tr.rbxcdn.com/38c6edcb50633730ff4cf39ac8859840/420/420/Hat/Png" className="w-full h-2/3 object-cover" />
                            <div className="h-1/3 w-full bg-gray-200 p-2 text-xl flex items-center justify-center">
                                <div className="text-center w-fit h-fit">
                                    Gabriel's Animal Home
                                </div>
                            </div>
                        </Link>
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