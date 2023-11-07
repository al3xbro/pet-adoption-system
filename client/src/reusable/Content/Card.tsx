type Props = {
    name: string,
    summary: string,
    desc: string,
    img: string,
}

export default function Card({ name, summary, desc, img }: Props) {
    return (
        <>
            <div className="rounded-xl h-52 w-full overflow-hidden">
                <img src={img} alt="" className="w-full h-2/3 object-cover" />
                <div className="flex flex-col justify-center bg-gray-200 h-1/3 py-1 px-3">
                    <div className="h-fit flex justify-between">
                        <div className="text-4xl">{name}</div>
                        <div className="self-end" >{summary}</div>
                    </div>
                </div>
            </div>
        </>
    )
}