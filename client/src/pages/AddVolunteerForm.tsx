import { useMutation } from "@tanstack/react-query"
import axios from "axios"
import { useState } from "react"

type Props = {
    shelterId: number,
    setShowAddVolunteerMenu: React.Dispatch<React.SetStateAction<boolean>>
}

interface VolunteerData {
    firstName: string,
    lastName: string,
    img: string
}


export default function AddVolunteerForm({ setShowAddVolunteerMenu }: Props) {

    const [firstName, setFirstName] = useState("")
    const [lastName, setLastName] = useState("")
    const [img, setImg] = useState("")

    const adopt = useMutation({
        mutationFn: async (data: VolunteerData) => {
            return axios.post("http://localhost:8080/api/volunteers", {
                firstName: data.firstName,
                lastName: data.lastName,
                hoursWorked: 0,
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

    function addVolunteer(firstName: string, lastName: string, img: string) {
        const data = {
            firstName: firstName,
            lastName: lastName,
            img: img
        }
        adopt.mutate(data)
        setShowAddVolunteerMenu(false)
    }

    return (
        <>
            <div className="fixed w-screen h-screen bottom-0 right-0 z-10 flex justify-center items-center">
                <div className="w-full h-full absolute bg-black opacity-40" onClick={() => { setShowAddVolunteerMenu(false) }}></div>
                <div className="max-w-[700px] max-h-[500px] w-1/2 h-1/2 z-20 px-10 py-10 bg-white rounded-2xl shadow-xl flex flex-col relative gap-5 overflow-hidden">
                    <div className="text-4xl font-bold">Adding Volunteer</div>
                    <div className="flex flex-col gap-5">
                        <div className="flex flex-col gap-2">
                            <div>Name</div>
                            <div className="flex gap-4">
                                <input className="bg-gray-200 rounded-md flex-1 p-2" type="text" placeholder="First" value={firstName} onChange={(e) => setFirstName(e.target.value)} />
                                <input className="bg-gray-200 rounded-md flex-1 p-2" type="text" placeholder="Last" value={lastName} onChange={(e) => setLastName(e.target.value)} />
                            </div>
                        </div>
                        <div className="flex flex-col gap-2">
                            <div>Image Link</div>
                            <input className="bg-gray-200 rounded-md w-full p-2" placeholder="Link" type="text" value={img} onChange={(e) => setImg(e.target.value)} />
                        </div>
                    </div>
                    <div className="absolute bottom-8 right-10 flex gap-2">
                        <div className="bg-red-500 p-2 w-[85px] text-center rounded-md hover:bg-red-400 transition ease-in-out duration-100" onClick={() => { setShowAddVolunteerMenu(false) }}>Cancel</div>
                        <div className="bg-blue-400 p-2 w-[85px] text-center rounded-md hover:bg-blue-300 transition ease-in-out duration-100" onClick={() => { addVolunteer(firstName, lastName, img) }}>Confirm</div>
                    </div>
                </div>
            </div>
        </>
    )
}