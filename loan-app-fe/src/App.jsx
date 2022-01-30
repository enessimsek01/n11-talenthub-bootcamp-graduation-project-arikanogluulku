import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/navbar/Navbar'
import CreditApplication from './components/credit/CreditApplication';
import Footer from './components/footer/Footer';
import UserList from './components/user/UserList';
import Home from './components/home/Home';
import UserSave from './components/user/UserSave';
function App() {
  return (
    <div className='layout'>
      <Router>
        <Navbar />
        <div className='content'>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/users" element={<UserList/> } />
            <Route path="/addUser" element={<UserSave/> } />
            <Route path="/credit" element={<CreditApplication />} />
          </Routes>
        </div>
        <Footer />
      </Router>
    </div>
  );
}

export default App;
