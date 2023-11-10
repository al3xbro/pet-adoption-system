import Main from './pages/Main'
import { createContext, useState } from 'react'
import { QueryClient, QueryClientProvider } from '@tanstack/react-query'

type Account = "shelter" | "volunteer" | "customer"
type AccountContextType = {
    accountType: Account,
    setAccountType: React.Dispatch<React.SetStateAction<Account>>
}

const AccountContext = createContext<AccountContextType | undefined>(undefined)
const queryClient = new QueryClient()

function App() {

    const [accountType, setAccountType] = useState<Account>("shelter")

    return (
        <>
            <QueryClientProvider client={queryClient}>
                <AccountContext.Provider value={{ accountType, setAccountType }}>
                    <Main />
                </AccountContext.Provider>
            </QueryClientProvider>
        </>
    )
}

export { AccountContext, App }