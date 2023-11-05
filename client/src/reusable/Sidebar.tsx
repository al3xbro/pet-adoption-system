type PaneView = "pets" | "volunteers" | "supplies" | "profile" | "none"

type Props = {
    paneView: PaneView,
    setPaneView: React.Dispatch<React.SetStateAction<PaneView>>
}

export default function Sidebar({ paneView, setPaneView }: Props) {
    return (
        <>
            <div className="h-72 sm:h-full sm:w-72 sm:border-r-2 sm:border-r-black sm:border-t-0 border-t-2 border-t-black" >sidebar</div>
        </>
    )
}