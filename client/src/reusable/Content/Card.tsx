import { useContext, useState } from "react"
import { AccountContext } from "../../App"
import AdoptForm from "../../pages/AdoptForm"

type Props = {
    id: number,
    name: string,
    summary: string,
    shelterId: number,
    desc: string,
    img: string,
}

function canAccess(accountType: string | undefined) {
    if (accountType === undefined) return false
    if (accountType === "customer") return false
    return true
}

export default function Card({ id, name, summary, shelterId, img }: Props) {

    const [showAdminDisplay, setShowAdminDisplay] = useState(false)
    const [showAdoptMenu, setShowAdoptMenu] = useState(false)
    const accountContext = useContext(AccountContext)

    return (
        <>
            {showAdoptMenu ? <AdoptForm petId={id} petName={name} shelterId={shelterId} setShowAdoptMenu={setShowAdoptMenu} /> : null}
            <div className="relative rounded-xl h-52 w-full overflow-hidden" onMouseEnter={() => { setShowAdminDisplay(true) }} onMouseLeave={() => { setShowAdminDisplay(false) }}>
                {canAccess(accountContext?.accountType) ?
                    <div className={`absolute right-[4%] top-[7%] flex gap-2 transition-opacity ease-in-out duration-100 ${showAdminDisplay ? "opacity-100" : "opacity-0"}`}>
                        <div className="bg-white p-2 rounded-md shadow-xl hover:bg-gray-200 transition ease-in-out duration-100" onClick={() => { setShowAdoptMenu(true) }}>Adopt</div>
                        <div className="bg-red-500 p-2 rounded-md shadow-xl hover:bg-red-400 transition ease-in-out duration-100">Delete</div>
                    </div>
                    :
                    null
                }
                <img src={img} alt="" className="w-full h-2/3 object-cover" />
                <div className="flex flex-col justify-center bg-gray-200 h-1/3 py-1 px-3">
                    <div className="h-fit flex justify-between">
                        <div className="text-2xl sm:text-3xl lg:text-4xl max-w-[60%] truncate">{name}</div>
                        <div className="self-end max-w-[50%] truncate" >{summary}</div>
                    </div>
                </div>
            </div>
        </>
    )
}