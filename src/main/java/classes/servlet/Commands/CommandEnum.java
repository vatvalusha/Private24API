package classes.servlet.Commands;

/**
 * Created by Valera on 16.01.2018.
 */
public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    USERS {
        {
            this.command = new Users();
        }
    },
    REGISTRATION {
        {
            this.command = new RegistrationSuccessful();
        }
    },
    DELETE {
        {
            this.command = new DeleteUser();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
