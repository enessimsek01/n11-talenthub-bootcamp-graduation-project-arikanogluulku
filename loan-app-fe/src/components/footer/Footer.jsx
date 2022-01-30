import React from 'react';
import './style.scss'
function Footer() {
    return (
        <footer className='footer'>
            <div className="footer__links">
            <a className="fab fa-linkedin" href="https://www.linkedin.com/in/arikanogluulku/" />
            </div>
            <div className="footer__info">
                created by
                <span>  Ülkü Arıkanoğlu  </span>
                ©2022 | January
            </div>
        </footer>
    );

}

export default Footer;
