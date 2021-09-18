
public class Worker {
    private final OnTaskDoneListener callback;
    private final OnTaskErrorListener errorCallback;

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






