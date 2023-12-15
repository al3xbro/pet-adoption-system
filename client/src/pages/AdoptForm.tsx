import { useMutation, useQuery } from "@tanstack/react-query"
import axios from "axios"
import { useState } from "react"
import Select from "react-select"

type Props = {
    petId: number,
    petName: string,
    shelterId: number,
    setShowAdoptMenu: React.Dispatch<React.SetStateAction<boolean>>
}

interface AdoptData {
    petId: number,
    customerId: number,
    volunteerId: number,
    shelterId: number
}


export default function AdoptForm({ petId, petName, shelterId, setShowAdoptMenu }: Props) {

    const [customerId, setCustomerId] = useState(1)

    const adopt = useMutation({
        mutationFn: async (data: AdoptData) => {
            return axios.post("http://localhost:8080/api/logs", {
                petId: data.petId,
                customerId: data.customerId,
                volunteerId: data.volunteerId,
                shelterId: data.shelterId
            },
                {
                    headers: {
                        "Content-Type": "application/json"
                    }
                }
            )
        }
    })

    const getCustomers = useQuery({
        queryKey: ["customers"],
        queryFn: async () => {
            return axios.get("http://localhost:8080/api/customers")
        }
    })

    function adoptPet(petId: number, customerId: any, volunteerId: number, shelterId: number) {
        const data = {
            "petId": petId,
            "customerId": customerId.value,
            "volunteerId": volunteerId,
            "shelterId": shelterId
        }
        adopt.mutate(data)
        setShowAdoptMenu(false)
    }

    const customerOptions = getCustomers.data?.data.map((customer: any) => {
        return {
            value: customer.id,
            label: `${customer.firstName} ${customer.lastName}`
        }
    })

    return (
        <>
            <div className="fixed w-screen h-screen bottom-0 right-0 z-10 flex justify-center items-center">
                <div className="w-full h-full absolute bg-black opacity-40" onClick={() => { setShowAdoptMenu(false) }}></div>
                <div className="max-w-[700px] max-h-[500px] w-1/2 h-1/2 z-20 px-10 py-10 bg-white rounded-2xl shadow-xl flex flex-col relative gap-5 overflow-hidden">
                    <div className="text-4xl font-bold">Adopting {petName}</div>
                    <div className="flex flex-col gap-2">
                        <div>Who's adopting?</div>
                        <Select value={customerId} options={customerOptions} onChange={(choice) => setCustomerId(choice ?? 1)} />
                    </div>
                    <div className="absolute bottom-8 right-10 flex gap-2">
                        <div className="bg-red-500 p-2 w-[85px] text-center rounded-md hover:bg-red-400 transition ease-in-out duration-100" onClick={() => { setShowAdoptMenu(false) }}>Cancel</div>
                        <div className="bg-blue-400 p-2 w-[85px] text-center rounded-md hover:bg-blue-300 transition ease-in-out duration-100" onClick={() => { adoptPet(petId, customerId, 1, shelterId) }}>Confirm</div>
                    </div>
                </div>
            </div>
        </>
    )
}