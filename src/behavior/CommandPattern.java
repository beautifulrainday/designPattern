package behavior;

/**
 * 命令模式
 * 将调用者、调用的指令、指令执行三者解耦
 */
public class CommandPattern {

    public static void main(String[] args) {
        Command watchAnimeCommand = new WatchAnimeCommand(new WatchAnimeInvoker());
        Command sleepCommand = new SleepCommand(new SleepInvoker());
        Caller caller = new Caller(watchAnimeCommand);
        Caller caller1 = new Caller(sleepCommand);

        caller.call();
        caller1.call();

    }

}

/**
 * 调用者
 */
class Caller {

    Command command;

    Caller(Command command) {
        this.command = command;
    }

    void call() {
        command.execute();
    }
}

/**
 * 命令
 */
abstract class Command {

    abstract void execute();

}

/**
 * 看动漫指令
 */
class WatchAnimeCommand extends Command {

    WatchAnimeInvoker watchAnimeInvoker;

    WatchAnimeCommand(WatchAnimeInvoker invoker) {
        this.watchAnimeInvoker = invoker;
    }

    @Override
    void execute() {
        watchAnimeInvoker.action();
    }
}

/**
 * 滚去睡觉，不要熬夜
 */
class SleepCommand extends Command {

    SleepInvoker sleepInvoker;

    SleepCommand(SleepInvoker sleepInvoker) {
        this.sleepInvoker = sleepInvoker;
    }

    @Override
    void execute() {
        sleepInvoker.action();
    }
}

/**
 * 执行者
 */
abstract class Invoker {

    abstract void action();

}

class WatchAnimeInvoker extends Invoker {

    @Override
    void action() {
        System.out.println("watch the anime");
    }
}

class SleepInvoker extends Invoker {

    @Override
    void action() {
        System.out.println("go to sleep");
    }
}




