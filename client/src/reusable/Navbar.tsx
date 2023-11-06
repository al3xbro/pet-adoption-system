import { TfiViewGrid, TfiAlignJustify, TfiSearch } from "react-icons/tfi";

type ContentView = "card" | "list"
type Account = "shelter" | "employee" | "customer"

type Props = {
    accountType: Account,

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

export default function Navbar({ accountType, contentView, setContentView, searchText, setSearchText, searchPlaceholderText }: Props) {

    return (
        <>
            <div className="h-16 w-full flex p-4 justify-between border-b-2 border-b-black">
                <div className="flex p-[0.375rem] rounded-md sm:hover:bg-gray-200 active:bg-gray-200 transition duration-200 ease-in-out aspect-square" onClick={() => toggleContentView(contentView, setContentView)}>
                    {contentView == "list" ?
                        <TfiAlignJustify className="w-full h-full" /> :
                        <TfiViewGrid className="w-full h-full" />
                    }
                </div>
                <div className="flex w-1/2 min-w-[10rem] max-w-[30rem] gap-2 bg-gray-200 px-3 py-2 rounded-md ">
                    <TfiSearch className="opacity-60 h-full aspect-square" />
                    <input type="text" className="w-full outline-none bg-transparent" placeholder={searchPlaceholderText} onChange={e => { setSearchText(e.target.value) }} value={searchText} />
                </div>
                <div>switch context</div>
            </div>
        </>
    )
}