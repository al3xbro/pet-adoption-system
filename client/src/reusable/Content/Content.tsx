import Card from "./Card"

type Props = {

}

const dummyCards = [
    {
        name: "Mittens",
        summary: "(F 10mo)",
        desc: "Mittens is a sweet, playful kitten who loves to cuddle and play with her toys. She is very friendly and loves to be petted. She is a little shy at first, but warms up quickly. She is good with other cats and dogs.",
        img: "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
    },
    {
        name: "Mittens",
        summary: "(F 10mo)",
        desc: "Mittens is a sweet, playful kitten who loves to cuddle and play with her toys. She is very friendly and loves to be petted. She is a little shy at first, but warms up quickly. She is good with other cats and dogs.",
        img: "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
    },
    {
        name: "Mittens",
        summary: "(F 10mo)",
        desc: "Mittens is a sweet, playful kitten who loves to cuddle and play with her toys. She is very friendly and loves to be petted. She is a little shy at first, but warms up quickly. She is good with other cats and dogs.",
        img: "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
    },
    {
        name: "Mittens",
        summary: "(F 10mo)",
        desc: "Mittens is a sweet, playful kitten who loves to cuddle and play with her toys. She is very friendly and loves to be petted. She is a little shy at first, but warms up quickly. She is good with other cats and dogs.",
        img: "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
    },
    {
        name: "Mittens",
        summary: "(F 10mo)",
        desc: "Mittens is a sweet, playful kitten who loves to cuddle and play with her toys. She is very friendly and loves to be petted. She is a little shy at first, but warms up quickly. She is good with other cats and dogs.",
        img: "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
    },
    {
        name: "Mittens",
        summary: "(F 10mo)",
        desc: "Mittens is a sweet, playful kitten who loves to cuddle and play with her toys. She is very friendly and loves to be petted. She is a little shy at first, but warms up quickly. She is good with other cats and dogs.",
        img: "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
    },
    {
        name: "Mittens",
        summary: "(F 10mo)",
        desc: "Mittens is a sweet, playful kitten who loves to cuddle and play with her toys. She is very friendly and loves to be petted. She is a little shy at first, but warms up quickly. She is good with other cats and dogs.",
        img: "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
    },
    {
        name: "Mittens",
        summary: "(F 10mo)",
        desc: "Mittens is a sweet, playful kitten who loves to cuddle and play with her toys. She is very friendly and loves to be petted. She is a little shy at first, but warms up quickly. She is good with other cats and dogs.",
        img: "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
    },
    {
        name: "Mittens",
        summary: "(F 10mo)",
        desc: "Mittens is a sweet, playful kitten who loves to cuddle and play with her toys. She is very friendly and loves to be petted. She is a little shy at first, but warms up quickly. She is good with other cats and dogs.",
        img: "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
    },
    {
        name: "Mittens",
        summary: "(F 10mo)",
        desc: "Mittens is a sweet, playful kitten who loves to cuddle and play with her toys. She is very friendly and loves to be petted. She is a little shy at first, but warms up quickly. She is good with other cats and dogs.",
        img: "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
    },
    {
        name: "Mittens",
        summary: "(F 10mo)",
        desc: "Mittens is a sweet, playful kitten who loves to cuddle and play with her toys. She is very friendly and loves to be petted. She is a little shy at first, but warms up quickly. She is good with other cats and dogs.",
        img: "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
    },
]

// get query params and fetches data here

export default function Content({ }: Props) {
    return (
        <>
            <div style={{ gridTemplateColumns: "repeat(auto-fill, minmax(16rem, 1fr))", gridAutoRows: "13rem" }} className="grid gap-8 h-[calc(100%-4rem)] sm:overflow-auto overflow-y-scroll p-6">
                {dummyCards.map(card => <Card name={card.name} summary={card.summary} desc={card.desc} img={card.img} />)}
            </div>
        </>
    )
}