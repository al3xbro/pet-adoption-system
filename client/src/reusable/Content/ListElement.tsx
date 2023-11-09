type Props = {
    name: string,
    summary: string,
    desc: string,
    img: string,
}

export default function ListElement({ name, summary, desc, img }: Props) {
    return (
        <>
            <div className="w-full h-10 border-b-[1px] border-gray-400 flex px-2 gap-10">
                <div className="h-fit my-auto text-xl sm:w-[350px] w-full flex gap-2 justify-between">
                    <div className="truncate w-[300px]">
                        {name}
                    </div>
                    <div className="w-[120px]">
                        {summary}
                    </div>
                </div>
                <div className="hidden sm:block truncate h-fit my-auto">
                    {desc}
                </div>
            </div >
        </>
    )
}