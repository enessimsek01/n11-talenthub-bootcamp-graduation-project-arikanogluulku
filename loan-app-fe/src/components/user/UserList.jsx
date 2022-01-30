import React from 'react';
import { useEffect, useState } from 'react';
import PageTittle  from '../PageTittle/PageTittle';
import { moneyFormatter } from '../../util/moneyFormatter';
import './style.scss';
import UserService from '../../service/UserService';
import UserUpdateModel from './UserUpdateModel';
import { Link } from 'react-router-dom';
function UserList() {

  const [users, setUsers] = useState([]);

  useEffect(() => {
    UserService.getAlluser()
      .then(response => setUsers(response.data))
      .catch(error => console.log(error));
  }, [users]);

  const deleteUser = (id) =>{
    UserService.deleteUser(id)
  }

  return (
  <div className='user'>
    <PageTittle tittle="User List"/>
    <Link to = "/addUser">
    <i class="fas fa-user-plus"/>
    </Link>

    <ul className="list">

      <li className="list__header">
        <div className="col col-2">Identification Number</div>
        <div className="col col-3">Name</div>
        <div className="col col-4">Surname</div>
        <div className="col col-5">Birthday</div>
        <div className="col col-6">Phone</div>
        <div className="col col-7">Salary</div>
        <div className="col col-8">Guarantee</div>
        <div className="col col-9">Islemler</div>
      </li>
      {
        users.map((user) => {
          return (
            <li className="list__item">
              <div className="col col-2" >{user.identificationNumber}</div>
              <div className="col col-3" >{user.name} </div>
              <div className="col col-4">{user.surname}</div>
              <div className="col col-5">{user.dateOfBirthday}</div>
              <div className="col col-6" >{user.phone}</div>
              <div className="col col-7" >{moneyFormatter.format(user.salary)}</div>
              <div className="col col-8">{moneyFormatter.format(user.guarantee)}</div>
              <div className="col col-9">
              <UserUpdateModel user ={user} />
              <i className="fas fa-trash-alt" onClick={() => deleteUser(user.id)}></i>
              </div>
            </li>
          );
        })
      }
    </ul>
    </div>);
}

export default UserList;
