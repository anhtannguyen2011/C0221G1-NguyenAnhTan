import {Position} from './Position';
import {Education} from './Education';
import {Division} from './Division';

export interface Employees {
  id: number,
  name: string
  position: Position,
  education: Education,
  division : Division,
  dateOfBirth: string,
  idCard: string,
  salary: number,
  phone: string,
  email: string,
  address: string
}
//"id" : 1,
//       "name" : "Nguyễn Anh Tấn",
//       "position" : [
//         {
//           "id": 1,
//           "name" : "Manager"
//         }
//       ],
//       "education" : [ {
//         "id": 1,
//         "name" : "Đại Học"
//       }],
//       "division" : [
//         {
//           "id" : 1,
//           "name" : "Maketting"
//         }
//       ],
//       "dateOfBirth" : "2012-12-12",
//       "idCard" : "201202120",
//       "salary" : 6000,
//       "phone" :  "0935454545",
//       "email" : "anhtannguyen2011@gmail.com",
//       "address" : "Đà Nẵng"
//     }
