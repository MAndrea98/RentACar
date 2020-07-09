import {Message} from "./Message";
export class UserModel{

  id: number;
  username: String;
  password: String;
  inbox: Array<Message>;
  outbox: Array<Message>;
  constructor() {
  }
}
