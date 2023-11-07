type AccountType = 'customer' | 'volunteer' | 'shelter'
type Props = {
    accountType: AccountType
}

export default function Sidebar({ accountType }: Props) {
    return (
        <>
            <div className="hidden sm:block sm:h-full sm:w-72 sm:border-r-2 sm:border-r-black sm:border-t-0 border-t-2 border-t-black" >{accountType} sidebar</div>
        </>
    )
}