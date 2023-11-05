import listIcon from "../assets/list_icon.svg"
import tileIcon from "../assets/tile_icon.svg"

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
                <img className="p-1 rounded-md sm:hover:bg-gray-200 active:bg-gray-200 transition duration-200 ease-in-out" src={contentView == "list" ? listIcon : tileIcon} onClick={() => toggleContentView(contentView, setContentView)} />
                <input type="text" className="p-2 rounded-md max-w-xl bg-gray-200" placeholder={searchPlaceholderText} onChange={e => { setSearchText(e.target.value) }} value={searchText} />
                <div>switch context</div>
            </div>
        </>
    )
}