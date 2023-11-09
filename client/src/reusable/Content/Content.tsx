import Card from "./Card"
import ListElement from "./ListElement"

type ContentView = "card" | "list"

type Props = {
    contentView: ContentView,
}

const dummyCards = [
    {
        id: 1,
        name: "Mittens",
        summary: "(F 10mo)",
        desc: "Mittens is a sweet, playful kitten who loves to cuddle and play with her toys. She is very friendly and loves to be petted. She is a little shy at first, but warms up quickly. She is good with other cats and dogs.",
        img: "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
    },
    {
        id: 2,
        name: "Mittens",
        summary: "(F 10mo)",
        desc: "Mittens is a sweet, playful kitten who loves to cuddle and play with her toys. She is very friendly and loves to be petted. She is a little shy at first, but warms up quickly. She is good with other cats and dogs.",
        img: "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
    },
    {
        id: 3,
        name: "Mittens",
        summary: "(F 10mo)",
        desc: "Mittens is a sweet, playful kitten who loves to cuddle and play with her toys. She is very friendly and loves to be petted. She is a little shy at first, but warms up quickly. She is good with other cats and dogs.",
        img: "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
    },
    {
        id: 4,
        name: "Mittens",
        summary: "(F 10mo)",
        desc: "Mittens is a sweet, playful kitten who loves to cuddle and play with her toys. She is very friendly and loves to be petted. She is a little shy at first, but warms up quickly. She is good with other cats and dogs.",
        img: "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
    },
    {
        id: 5,
        name: "Mittens",
        summary: "(F 10mo)",
        desc: "Mittens is a sweet, playful kitten who loves to cuddle and play with her toys. She is very friendly and loves to be petted. She is a little shy at first, but warms up quickly. She is good with other cats and dogs.",
        img: "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
    },
    {
        id: 6,
        name: "Mittens",
        summary: "(F 10mo)",
        desc: "Mittens is a sweet, playful kitten who loves to cuddle and play with her toys. She is very friendly and loves to be petted. She is a little shy at first, but warms up quickly. She is good with other cats and dogs.",
        img: "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
    },
    {
        id: 7,
        name: "Mittensasdfasfaasdfasdf",
        summary: "(F 10mo)",
        desc: "Mittens is a sweet, playful kitten who loves to cuddle and play with her toys. She is very friendly and loves to be petted. She is a little shy at first, but warms up quickly. She is good with other cats and dogs.",
        img: "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
    },
    {
        id: 8,
        name: "Mittens",
        summary: "(F 10mo)",
        desc: "Mittens is a sweet, playful kitten who loves to cuddle and play with her toys. She is very friendly and loves to be petted. She is a little shy at first, but warms up quickly. She is good with other cats and dogs.",
        img: "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
    },
    {
        id: 9,
        name: "Mittens",
        summary: "(F 10mo)",
        desc: "Mittens is a sweet, playful kitten who loves to cuddle and play with her toys. She is very friendly and loves to be petted. She is a little shy at first, but warms up quickly. She is good with other cats and dogs.",
        img: "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
    },
    {
        id: 10,
        name: "Mittens",
        summary: "(F 10mo)",
        desc: "Mittens is a sweet, playful kitten who loves to cuddle and play with her toys. She is very friendly and loves to be petted. She is a little shy at first, but warms up quickly. She is good with other cats and dogs.",
        img: "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
    },
    {
        id: 11,
        name: "Mittens",
        summary: "(F 10mo)",
        desc: "Mittens is a sweet, playful kitten who loves to cuddle and play with her toys. She is very friendly and loves to be petted. She is a little shy at first, but warms up quickly. She is good with other cats and dogs.",
        img: "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
    },
]

// get query params and fetches data here

export default function Content({ contentView }: Props) {
    return (
        <>
            {contentView == "card" ?
                <div style={{ gridTemplateColumns: "repeat(auto-fill, minmax(20rem, 1fr))", gridAutoRows: "13rem" }} className="grid gap-8 h-[calc(100%-4rem)] overflow-y-auto p-6">
                    {dummyCards.map(card => <Card key={card.id} name={card.name} summary={card.summary} desc={card.desc} img={card.img} />)}
                </div>
                : <div className="h-[calc(100%-4rem)] overflow-y-auto px-6">
                    {dummyCards.map(card => <ListElement key={card.id} name={card.name} summary={card.summary} desc={card.desc} img={card.img} />)}
                </div>
            }
        </>
    )
}