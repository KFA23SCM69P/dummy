import matplotlib.pyplot as plt


def trace_file(filename, range):
    address_counts = {}  # Dictionary to store address counts
    freq = {
        "read_count": 0,
        "write_count": 0,
        "fetch": 0
    }

    with open(filename, 'r') as file:
        for line in file:
            operation, address_hex = line.strip().split()
            address = int(address_hex, 16)  # Convert hexadecimal address to decimal
            # Check if the address is within the selected range
            if range[0] <= address <= range[1]:
                if address in address_counts:
                    address_counts[address] += 1
                else:
                    address_counts[address] = 1

                if operation == '0':  # Read operation
                    freq["read_count"] += 1
                elif operation == '1':  # Write operation
                    freq["write_count"] += 1
                elif operation == '2':
                    freq["fetch"] += 1

    return address_counts, freq


def plot_histogram(address_counts, frequency, title):
    addresses = list(address_counts.keys())
    counts = list(address_counts.values())
    plt.figure(figsize=(10, 6))
    plt.bar(addresses, counts, width=.5, color='red')
    plt.title(title)
    plt.xlabel('Address (Decimal)')
    plt.ylabel('Frequency of Address')
    # Add annotations for read and write frequencies
    plt.annotate(f'Reads: {frequency["read_count"]}', xy=(0.05, 0.9), xycoords='axes fraction', fontsize=12)
    plt.annotate(f'Writes: {frequency["write_count"]}', xy=(0.05, 0.85), xycoords='axes fraction', fontsize=12)
    plt.annotate(f'Fetch: {frequency["fetch"]}', xy=(0.05, 0.8), xycoords='axes fraction', fontsize=12)
    plt.grid(True)
    plt.show()



range = (4394199, 4397400) #range for the cc1.din
range =   (268519512, 268519880) #Range for the spice.din 

# Parse and plot histograms for cc1.din
cc1_address_counts, freq = trace_file('/Users/kuldeeppatel/Desktop/cc1.din', range)
plot_histogram(dict(cc1_address_counts), freq, 'Histogram for cc1.din')

spice_address_counts, freq = trace_file('/Users/kuldeeppatel/Desktop/spice.din', range)
plot_histogram(spice_address_counts,freq, 'Histogram for spice.din')