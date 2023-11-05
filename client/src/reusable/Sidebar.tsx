type PaneView = "pets" | "volunteers" | "supplies" | "profile" | "none"

type Props = {
    paneView: PaneView,
    setPaneView: (paneView: PaneView) => void
}

export default function Sidebar({ paneView, setPaneView }: Props) {
    return (
        <>
            <div className="h-72 sm:h-full sm:w-72 bg-green-500" >sidebar</div>
        </>
    )
}