type ContentView = "card" | "list"
type Account = "shelter" | "employee" | "customer"

type Props = {
    accountType: Account,

    contentView: ContentView,
    setContentView: (contentView: ContentView) => void,

    setSearchText: (searchText: string) => void,
    searchPlaceholderText: string,
}

export default function Navbar({ accountType, contentView, setContentView, setSearchText, searchPlaceholderText }: Props) {
    return (
        <>
            <div className="h-16 w-full bg-red-500">navigation</div>
        </>
    )
}