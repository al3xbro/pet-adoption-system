import { useMutation } from "@tanstack/react-query"
import axios from "axios"
import { useState } from "react"
import Select from "react-select"

type Props = {
    shelterId: number,
    setShowAddPetMenu: React.Dispatch<React.SetStateAction<boolean>>
}

interface PetData {
    name: string,
    age: number,
    species: string,
    breed: string,
    sex: Sex,
    img: string
}

type Sex = "M" | "F"

const sexOptions = [
    { value: "M", label: "Male" },
    { value: "F", label: "Female" }
]

export default function AddPetForm({ setShowAddPetMenu }: Props) {


    const [name, setName] = useState("")
    const [age, setAge] = useState(0)
    const [species, setSpecies] = useState("")
    const [breed, setBreed] = useState("")
    const [sex, setSex] = useState<Sex>("M")
    const [img, setImg] = useState("")

    const adopt = useMutation({
        mutationFn: async (data: PetData) => {
            return axios.post("http://localhost:8080/api/pets", {
                petName: data.name,
                petAge: data.age,
                petSpecies: data.species,
                petBreed: data.breed,
                shelterId: 1,
                petSex: data.sex,
                img: data.img
            },
                {
                    headers: {
                        "Content-Type": "application/json"
                    }
                }
            )
        }
    })

    function addPet(name: string, age: number, species: string, breed: string, sex: Sex, img: string) {
        const data = {
            "name": name,
            "age": age,
            "species": species,
            "breed": breed,
            "sex": sex,
            "img": img
        }
        adopt.mutate(data)
        setShowAddPetMenu(false)
    }

    return (
        <>
            <div className="fixed w-screen h-screen bottom-0 right-0 z-10 flex justify-center items-center">
                <div className="w-full h-full absolute bg-black opacity-40" onClick={() => { setShowAddPetMenu(false) }}></div>
                <div className="max-w-[700px] max-h-[600px] w-1/2 h-3/5 z-20 px-10 py-10 bg-white rounded-2xl shadow-xl flex flex-col relative gap-5 overflow-hidden">
                    <div className="text-4xl font-bold">Adding Pet</div>
                    <div className="flex flex-col gap-5">
                        <div className="flex flex-col gap-2">
                            <div>Name</div>
                            <input className="bg-gray-200 rounded-md flex-1 p-2" type="text" placeholder="Bubbles" value={name} onChange={(e) => setName(e.target.value)} />
                        </div>
                        <div className="flex gap-4">
                            <div className="flex flex-col gap-2 flex-1">
                                <div>Age</div>
                                <input className="bg-gray-200 rounded-md flex-1 p-2" type="number" placeholder="10" value={age} onChange={(e) => setAge(e.target.valueAsNumber)} />
                            </div>
                            <div className="flex flex-col gap-2 flex-1">
                                <div>Sex</div>
                                {/* @ts-ignore */}
                                <Select value={sex} options={sexOptions} onChange={(choice) => setSex(choice ?? "M")} />
                            </div>
                        </div>
                        <div className="flex gap-4">
                            <div className="flex flex-col gap-2 flex-1">
                                <div>Species</div>
                                <input className="bg-gray-200 rounded-md flex-1 p-2" type="text" placeholder="Species" value={species} onChange={(e) => setSpecies(e.target.value)} />
                            </div>
                            <div className="flex flex-col gap-2 flex-1">
                                <div>Breed</div>
                                <input className="bg-gray-200 rounded-md flex-1 p-2" type="text" placeholder="Breed" value={breed} onChange={(e) => setBreed(e.target.value)} />
                            </div>
                        </div>
                        <div className="flex flex-col gap-2">
                            <div>Image Link</div>
                            <input className="bg-gray-200 rounded-md w-full p-2" placeholder="Raw" type="text" value={img} onChange={(e) => setImg(e.target.value)} />
                        </div>
                    </div>
                    <div className="absolute bottom-8 right-10 flex gap-2">
                        <div className="bg-red-500 p-2 w-[85px] text-center rounded-md hover:bg-red-400 transition ease-in-out duration-100" onClick={() => { setShowAddPetMenu(false) }}>Cancel</div>
                        <div className="bg-blue-400 p-2 w-[85px] text-center rounded-md hover:bg-blue-300 transition ease-in-out duration-100" onClick={() => { addPet(name, age, species, breed, sex, img) }}>Confirm</div>
                    </div>
                </div>
            </div>
        </>
    )
}