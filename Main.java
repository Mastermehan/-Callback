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
