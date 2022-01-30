import React from 'react';
import { Link } from 'react-router-dom';
import './style.scss'
function Navbar() {
  return (
    <nav className="navbar navbar-expand-lg navbar-light ">
      <div className="container-fluid">
        <img className='navbar__logo' href="/" src='https://kurumsal.n11.com/assets/logo/logo-n11-large.png' alt="" />
        <a className="navbar__title" href="/">TalentHub Java Bootcamp Project</a>
        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse navbar__items" id="navbarNavAltMarkup">
          <div className="navbar-nav ">
          <a className="navbar__item" aria-current="page" href="/">Credit Inquiry</a>
            <a className="navbar__item" aria-current="page" href="/credit">Credit Application</a>
            <a className="navbar__item" aria-current="page" href="/users">User Operations</a>
          </div>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;
