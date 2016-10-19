package workshop.hello.api;

/**
 * Created by somkiat on 10/19/2016 AD.
 */
class MockCallback implements CalculatorApi.CalculatorApiCallback {

    private boolean called = false;

    public boolean verify() {
        return this.called;
    }

    @Override
    public void onSuccess(String result) {
        System.out.println("=======");
//        assert "5.00".equals(result);
        called = true;
    }
}
