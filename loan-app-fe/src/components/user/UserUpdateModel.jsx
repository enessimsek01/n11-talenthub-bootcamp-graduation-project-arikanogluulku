
import React, { useState } from 'react';
import Modal from 'react-bootstrap/Modal';
import UserService from '../../service/UserService';
import PageTittle from '../PageTittle/PageTittle';
import FormInputItem from '../form/FormInputItem';
import './style.scss';
function UserUpdateModel({user}) {
    const [show, setShow] = useState(false);
    const [name, setName] = useState(user.name);
    const [surname, setSurname] = useState(user.surname)
    const [dateOfBirthday, setDateOfBirthday] = useState(user.dateOfBirthday);
    const [phone, setPhone] = useState(user.phone);
    const [identificationNumber, setIdentificationNumber] = useState(user.identificationNumber);
    const [salary, setSalary] = useState(user.salary);
    const [guarantee, setGuarantee] = useState(user.guarantee);


    const handleModalClick = () => {
        setShow(true);
    };
    const updateUser = (id, updatedUser) => {
        UserService.updateUser(id, updatedUser)
        setTimeout(setShow(false), 1000);
    }
    const handleFormSubmit = (e) => {
        e.preventDefault();
        updateUser(user.id, newUser);
    }
    const newUser = ({
        name, surname, dateOfBirthday, identificationNumber, phone, salary, guarantee
    });
    return <>
        <i className="fas fa-user-edit" onClick={() => handleModalClick()} ></i>
        <Modal
            show={show}
            onHide={() => setShow(false)}
            keyboard={false}
            centered
        >
            <PageTittle tittle="Update User" />
            <form id="user-form" className="mx-2" onSubmit={handleFormSubmit}>
                <FormInputItem label="Name" type="text" name="name" value={name} onChange={(e) => setName(e.target.value)} />
                <FormInputItem label="Surname" type="text" name="surname" value={surname} onChange={(e) => setSurname(e.target.value)} />
                <FormInputItem label="Identification Number" type="text" name="identificationNumber" value={identificationNumber} onChange={(e) => setIdentificationNumber(e.target.value)} />
                <FormInputItem label="Birthday" type="date" name="dateOfBirthday" value={dateOfBirthday} onChange={(e) => setDateOfBirthday(e.target.value)} />
                <FormInputItem label="Phone" type="text" name="phone" value={phone} onChange={(e) => setPhone(e.target.value)} />
                <FormInputItem label="Salary" type="number" name="salary" value={salary} onChange={(e) => setSalary(e.target.value)} />
                <FormInputItem label="Guarantee" type="number" name="guarantee" value={guarantee} onChange={(e) => setGuarantee(e.target.value)} />
                <button className='form__button' type="submit">Update User</button>
            </form>
        </Modal>

    </>;
}

export default UserUpdateModel;
