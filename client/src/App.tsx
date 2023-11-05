import { BrowserRouter, Routes, Route } from 'react-router-dom'
import CustomerView from './pages/CustomerView'
import EmployeeView from './pages/EmployeeView'
import ShelterView from './pages/ShelterView'

export default function App() {
    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route path='/customer' element={<CustomerView />} />
                    <Route path='/employee' element={<EmployeeView />} />
                    <Route path='/shelter' element={<ShelterView />} />
                </Routes>
            </BrowserRouter>
        </>
    )
}