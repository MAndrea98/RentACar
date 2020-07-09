import {UserModel} from "./UserModel";

export class Message{

  id: number;
  sender: UserModel
  receiver: UserModel;
  subject: String;
  content: String;
  dateM: Date;

  constructor() {
  }
}

