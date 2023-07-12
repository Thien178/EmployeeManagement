import { User } from "./user";
export class Employee {
    id : any = null;
    name! : string;
    dob! : string;
    email! : string;
    department! : string;
    designation! : string;
    reportingManager! : string;
    user! : User;
}
