import React from 'react';
import FormInputItem from '../form/FormInputItem';
import { useFormik } from 'formik';
import validationSchema from '../form/Validate';
function Form({handleFormsubmit , initialValues , buttonName}) {

    const { handleSubmit, handleChange, handleBlur, values, errors, touched } = useFormik({
        initialValues : {initialValues},
        onSubmit: (values) => {
            handleFormsubmit(values);
        },
        validationSchema,
    })
    
    return (
        <>
            <form id="form" className="mx-2" onSubmit={handleSubmit} >
                <FormInputItem label="Name" type="text" name="name" value={values.name} onChange={handleChange} onBlur={handleBlur} />
                {errors.name && touched.name && (<p className='error'>{errors.name}</p>)}
                <FormInputItem label="Surname" type="text" name="surname" value={values.surname} onChange={handleChange} onBlur={handleBlur} />
                {errors.surname && touched.surname && (<p className='error'>{errors.surname}</p>)}
                <FormInputItem label="Identification Number" type="text" name="identificationNumber" value={values.identificationNumber} onChange={handleChange} onBlur={handleBlur} />
                {errors.identificationNumber && touched.identificationNumber && (<p className='error'>{errors.identificationNumber}</p>)}
                <FormInputItem label="Birthday" type="date" name="dateOfBirthday" value={values.dateOfBirthday} onChange={handleChange} onBlur={handleBlur}/>
                {errors.dateOfBirthday && touched.dateOfBirthday && (<p className='error'>{errors.dateOfBirthday}</p>)}
                <FormInputItem label="Phone" type="text" name="phone" value={values.phone} onChange={handleChange} onBlur={handleBlur} />
                {errors.phone && touched.phone && (<p className='error'>{errors.phone}</p>)}
                <FormInputItem label="Salary" type="number" name="salary" value={values.salary} onChange={handleChange} onBlur={handleBlur}/>
                {errors.salary && touched.salary && (<p className='error'>{errors.salary}</p>)}
                <FormInputItem label="Guarantee(Optional)" type="number" name="guarantee" value={values.guarantee} onChange={handleChange} onBlur={handleBlur}/>
                {errors.guarantee && touched.guarantee && (<p className='error'>{errors.guarantee}</p>)}
                <button className='form__button' type="submit">{buttonName}</button>
            </form>
        </>
    );
}

export default Form;
