import React from 'react';
import PageTittle from '../PageTittle/PageTittle';
import UserService from '../../service/UserService';
import { useNavigate } from "react-router-dom";
import Form from '../form/Form';


function UserSave() {

    let navigate = useNavigate();
    const  initialValues={
        name: "",
        surname: "",
        identificationNumber: "",
        dateOfBirthday: "",
        phone: "",
        salary: 0,
        guarantee: 0,
    }

    const saveUser = (user) => {
        UserService.saveUser(user)
            .then(response => console.log(user))
            .catch(error => console.log(error));
    }

    const handleFormSubmit = (values) => {
        saveUser(values);
        navigate("/users");
    }
  return <>
  <PageTittle tittle="User Save" />
  <Form handleFormsubmit = {handleFormSubmit}  initialValues={initialValues}  buttonName="Save"/>
  </>;
}

export default UserSave;
