import * as Yup from 'yup';
const validationSchema = Yup.object().shape({
    name: Yup.string().min(3).max(20).required(),
    surname:  Yup.string().min(3).max(20).required(),
    identificationNumber: Yup.string().min(11).max(11).required(),
    dateOfBirthday: Yup.date().default(() => new Date()),
    phone:Yup.string().min(11).max(11).required(),
    salary:Yup.number().min(0).required(),
    guarantee:Yup.number().min(0),
  });

export default validationSchema;
