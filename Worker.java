class Main {
    public static void main(String[] args) {
        //определяем переменную listener типа OnTaskDoneListener через лямбда-выражение:
        OnTaskDoneListener listener1 = System.out::println;
        OnTaskErrorListener listener2 = System.out::println;
        //создаем экземпляр класса Worker и передаем в конструктор класса listener
        Worker worker = new Worker(listener1, listener2);
        worker.start();
    }
}

//собственный функциональный интерфейс
@FunctionalInterface
interface OnTaskDoneListener {
    void onDone(String result);
}

@FunctionalInterface
interface OnTaskErrorListener {
    void onError(String message);
}

public class Worker {
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    //Передаем в класс Worker ее значение через конструктор:
    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    //Передаем в класс Worker ее значение через конструктор:
    //Моделируем выполнение классом Worker какой либо работы
    public void start() {
        for (int i = 0; i < 100; i++) {
            if(i == 33) {
                errorCallback.onError("Error in task " + i);
            }  else {
                callback.onDone("Task " + i + " is done");
            }
        }
    }
}






