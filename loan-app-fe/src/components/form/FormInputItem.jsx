import React from 'react';
import './style.scss'
function FormInputItem({ label, ...props }) {
    return (
        <div className="form__item">
            <label className="form__label">{label}</label>
            <input className="form__input" {...props} />
        </div>
    );

}

export default FormInputItem;
