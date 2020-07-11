import {Message} from "./Message";

import {UserType} from "./UserType";
import{PermissionsEnum} from "./PermissionsEnum";

export class UserModel{

  id: number;
  username: String;
  password: String;
  inbox: Array<Message>;
  outbox: Array<Message>;
  constructor() {
  }
}
