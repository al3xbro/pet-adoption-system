import { useState } from 'react'
import CustomerView from './pages/CustomerView'
import VolunteerView from './pages/VolunteerView'
import ShelterView from './pages/ShelterView'

type AccountType = 'customer' | 'volunteer' | 'shelter'

export default function App() {

    // this is here just for the demo. make a login after
    const [accountType, setAccountType] = useState<AccountType>('shelter')

    return (
        <>
            {accountType == 'customer' ? <CustomerView /> : null}
            {accountType == 'volunteer' ? <VolunteerView /> : null}
            {accountType == 'shelter' ? <ShelterView setAccountType={setAccountType} /> : null}
        </>
    )
}