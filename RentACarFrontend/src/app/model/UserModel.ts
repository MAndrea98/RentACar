import {Message} from "./Message";

import {UserType} from "./UserType";
import{PermissionsEnum} from "./PermissionsEnum";

export class UserModel{

  id: number;
  username: String;
  password: String;
  uloga:UserType
  inbox: Array<Message>;
  outbox: Array<Message>;
  permissions: Set<PermissionsEnum>
  constructor() {
  }
}
