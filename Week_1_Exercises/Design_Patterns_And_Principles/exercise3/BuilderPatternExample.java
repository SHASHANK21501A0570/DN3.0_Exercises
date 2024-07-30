public class BuilderPatternExample {

    public static class Computer {
        private String cpu;
        private String ram;
        private String storage;
        private boolean graphicsCardEnabled;
        private boolean bluetoothEnabled;

        private Computer(Builder builder) {
            this.cpu = builder.cpu;
            this.ram = builder.ram;
            this.storage = builder.storage;
            this.graphicsCardEnabled = builder.graphicsCardEnabled;
            this.bluetoothEnabled = builder.bluetoothEnabled;
        }

        public String getCpu() {
            return cpu;
        }

        public String getRam() {
            return ram;
        }

        public String getStorage() {
            return storage;
        }

        public boolean isGraphicsCardEnabled() {
            return graphicsCardEnabled;
        }

        public boolean isBluetoothEnabled() {
            return bluetoothEnabled;
        }

        public static class Builder {
            private String cpu;
            private String ram;
            private String storage;
            private boolean graphicsCardEnabled;
            private boolean bluetoothEnabled;

            public Builder(String cpu, String ram, String storage) {
                this.cpu = cpu;
                this.ram = ram;
                this.storage = storage;
            }

            public Builder setGraphicsCardEnabled(boolean graphicsCardEnabled) {
                this.graphicsCardEnabled = graphicsCardEnabled;
                return this;
            }

            public Builder setBluetoothEnabled(boolean bluetoothEnabled) {
                this.bluetoothEnabled = bluetoothEnabled;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }

    public static void main(String[] args) {
        Computer gamingComputer = new Computer.Builder("Intel Core i9", "32GB", "2TB SSD")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        Computer officeComputer = new Computer.Builder("AMD Ryzen 7", "16GB", "1TB HDD")
                .setGraphicsCardEnabled(false)
                .setBluetoothEnabled(false)
                .build();

        System.out.println("Gaming Computer Specifications:");
        System.out.println("CPU: " + gamingComputer.getCpu());
        System.out.println("RAM: " + gamingComputer.getRam());
        System.out.println("Storage: " + gamingComputer.getStorage());
        System.out.println("Graphics Card Enabled: " + gamingComputer.isGraphicsCardEnabled());
        System.out.println("Bluetooth Enabled: " + gamingComputer.isBluetoothEnabled());

        System.out.println("\nOffice Computer Specifications:");
        System.out.println("CPU: " + officeComputer.getCpu());
        System.out.println("RAM: " + officeComputer.getRam());
        System.out.println("Storage: " + officeComputer.getStorage());
        System.out.println("Graphics Card Enabled: " + officeComputer.isGraphicsCardEnabled());
        System.out.println("Bluetooth Enabled: " + officeComputer.isBluetoothEnabled());
    }
}
