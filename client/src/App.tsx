import Main from './pages/Main'
import { createContext, useState } from 'react'

type Account = "shelter" | "volunteer" | "customer"
type AccountContextType = {
    accountType: Account,
    setAccountType: React.Dispatch<React.SetStateAction<Account>>
}

const AccountContext = createContext<AccountContextType | undefined>(undefined)

function App() {

    const [accountType, setAccountType] = useState<Account>("shelter")

    return (
        <>
            <AccountContext.Provider value={{ accountType, setAccountType }}>
                <Main />
            </AccountContext.Provider>
        </>
    )
}

export { AccountContext, App }