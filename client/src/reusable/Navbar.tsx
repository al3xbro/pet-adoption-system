import { useEffect, useRef, useState } from "react";
import { TfiViewGrid, TfiAlignJustify, TfiSearch, TfiAngleDown } from "react-icons/tfi";

type ContentView = "card" | "list"
type AccountType = "shelter" | "volunteer" | "customer"

type Props = {
    accountType: AccountType,
    setAccountType: React.Dispatch<React.SetStateAction<AccountType>>,

    contentView: ContentView,
    setContentView: React.Dispatch<React.SetStateAction<ContentView>>,

    searchText: string,
    setSearchText: React.Dispatch<React.SetStateAction<string>>,
    searchPlaceholderText: string,
}

function toggleContentView(contentView: ContentView, setContentView: React.Dispatch<React.SetStateAction<ContentView>>) {
    if (contentView == "list") {
        setContentView("card")
    } else {
        setContentView("list")
    }
}

export default function Navbar({ accountType, setAccountType, contentView, setContentView, searchText, setSearchText, searchPlaceholderText }: Props) {

    const [dropdownState, setDropdownState] = useState(false)
    const dropdownRef = useRef(null);

    function toggleDropdown(dropdownState: boolean) {
        // need settimeout to prevent dropdown from closing immediately
        setTimeout(() => {
            setDropdownState(!dropdownState)
        });
    }

    useEffect(() => {
        // add a click event listener to the document
        function exitMenus() {
            console.log("outside")
            if (dropdownRef.current) {
                setDropdownState(false);
            }
        }

        document.addEventListener('click', exitMenus);
        return () => {
            document.removeEventListener('click', exitMenus);
        }
    }, []);

    return (
        <>
            <div className="h-16 w-full flex p-4 justify-between border-b-2 border-b-black">
                <div className="flex p-[0.375rem] rounded-md sm:hover:bg-gray-200 active:bg-gray-200 transition duration-200 ease-in-out aspect-square" onClick={() => toggleContentView(contentView, setContentView)}>
                    {contentView == "list" ?
                        <TfiAlignJustify className="w-full h-full" /> :
                        <TfiViewGrid className="w-full h-full" />
                    }
                </div>
                <div className="flex w-1/2 min-w-[10rem] max-w-[30rem] gap-2 bg-gray-200 px-3 py-2 rounded-md">
                    <TfiSearch className="opacity-60 h-full aspect-square" />
                    <input type="text" className="w-full outline-none bg-transparent" placeholder={searchPlaceholderText} onChange={e => { setSearchText(e.target.value) }} value={searchText} />
                </div>
                <div className={`flex items-center gap-1 px-[0.375rem] rounded-md sm:hover:bg-gray-200 ${dropdownState ? "bg-gray-200" : ""} transition duration-200 ease-in-out`} onClick={() => toggleDropdown(dropdownState)}>
                    {accountType == "customer" ? "Customer" : null}
                    {accountType == "volunteer" ? "Volunteer" : null}
                    {accountType == "shelter" ? "Shelter" : null}
                    <TfiAngleDown className="w-3" />
                </div>
            </div>
            {dropdownState ?
                <div ref={dropdownRef} className="absolute top-14 right-4 overflow-hidden bg-gray-200 border rounded-md shadow-xl transition duration-200 ease-in-out">
                    <div className="py-1 px-2 hover:bg-gray-300" onClick={() => setAccountType("customer")}>Customer</div>
                    <div className="py-1 px-2 hover:bg-gray-300 border-y-[1px] border-gray-400" onClick={() => setAccountType("volunteer")}>Volunteer</div>
                    <div className="py-1 px-2 hover:bg-gray-300" onClick={() => setAccountType("shelter")}>Shelter</div>
                </div> : null
            }
        </>
    )
}